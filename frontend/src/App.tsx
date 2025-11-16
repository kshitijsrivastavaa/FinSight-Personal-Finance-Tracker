import React, { useState, useEffect } from 'react';
import { PieChart, Pie, Cell, Tooltip, ResponsiveContainer } from 'recharts';

type User = {
  id: number;
  name: string;
  email: string;
};

type Transaction = {
  id?: number;
  amount: number;
  type: 'INCOME' | 'EXPENSE';
  category: string;
  description?: string;
  date: string;
};

type Summary = {
  totalIncome: number;
  totalExpense: number;
  netSavings: number;
};

type AuthResponse = {
  token: string;
  user: User;
};

const API_BASE = 'https://finsight-backend-qiwc.onrender.com/api';

const App: React.FC = () => {
  const [user, setUser] = useState<User | null>(null);
  const [token, setToken] = useState<string | null>(() => localStorage.getItem('finsight_token'));
  const [authForm, setAuthForm] = useState({ name: '', email: '', password: '' });
  const [transactions, setTransactions] = useState<Transaction[]>([]);
  const [newTx, setNewTx] = useState<Transaction>({
    amount: 0,
    type: 'EXPENSE',
    category: 'FOOD',
    description: '',
    date: new Date().toISOString().slice(0, 10),
  });
  const [summary, setSummary] = useState<Summary | null>(null);
  const [byCategory, setByCategory] = useState<{ name: string; value: number }[]>([]);

  const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042', '#aa46be', '#ff6f91'];

  const authHeaders = token
    ? { Authorization: `Bearer ${token}`, 'Content-Type': 'application/json' }
    : { 'Content-Type': 'application/json' };

  const handleRegister = async () => {
    const res = await fetch(`${API_BASE}/auth/register`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(authForm),
    });
    if (res.ok) {
      const data: AuthResponse = await res.json();
      setUser(data.user);
      setToken(data.token);
      localStorage.setItem('finsight_token', data.token);
    } else {
      alert('Registration failed');
    }
  };

  const handleLogin = async () => {
    const res = await fetch(`${API_BASE}/auth/login`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: authForm.email, password: authForm.password }),
    });
    if (res.ok) {
      const data: AuthResponse = await res.json();
      setUser(data.user);
      setToken(data.token);
      localStorage.setItem('finsight_token', data.token);
    } else {
      alert('Login failed');
    }
  };

  const loadUserFromToken = async (existingToken: string) => {
    // Simple approach: decode token not on client, but call a "me" endpoint later.
    // For now, token will be refreshed only on login/register.
  };

  const loadData = async (u: User) => {
    const txRes = await fetch(`${API_BASE}/transactions?userId=${u.id}`, {
      headers: authHeaders,
    });
    if (txRes.ok) {
      const txData = await txRes.json();
      setTransactions(txData);
    }

    const sumRes = await fetch(`${API_BASE}/analytics/summary?userId=${u.id}`, {
      headers: authHeaders,
    });
    if (sumRes.ok) {
      const s = await sumRes.json();
      setSummary(s);
    }

    const catRes = await fetch(`${API_BASE}/analytics/by-category?userId=${u.id}`, {
      headers: authHeaders,
    });
    if (catRes.ok) {
      const cat = await catRes.json();
      const arr = Object.keys(cat).map((k) => ({ name: k, value: cat[k] }));
      setByCategory(arr);
    }
  };

  useEffect(() => {
    if (user && token) {
      loadData(user);
    }
  }, [user, token]);

  const handleAddTransaction = async () => {
    if (!user) return;
    const res = await fetch(`${API_BASE}/transactions?userId=${user.id}`, {
      method: 'POST',
      headers: authHeaders,
      body: JSON.stringify(newTx),
    });
    if (res.ok) {
      const tx = await res.json();
      setTransactions((prev) => [...prev, tx]);
      loadData(user);
    } else {
      alert('Failed to add transaction');
    }
  };

  const handleDeleteTransaction = async (id?: number) => {
    if (!id) return;
    await fetch(`${API_BASE}/transactions/${id}`, {
      method: 'DELETE',
      headers: authHeaders,
    });
    if (user) {
      loadData(user);
    }
  };

  const handleLogout = () => {
    setUser(null);
    setToken(null);
    localStorage.removeItem('finsight_token');
  };

  if (!user) {
    return (
      <div className="auth-container">
        <h1>FinSight 💰</h1>
        <p>Track your expenses, budgets and savings.</p>
        <div className="auth-forms">
          <div className="card">
            <h2>Register</h2>
            <input
              placeholder="Name"
              value={authForm.name}
              onChange={(e) => setAuthForm({ ...authForm, name: e.target.value })}
            />
            <input
              placeholder="Email"
              value={authForm.email}
              onChange={(e) => setAuthForm({ ...authForm, email: e.target.value })}
            />
            <input
              type="password"
              placeholder="Password"
              value={authForm.password}
              onChange={(e) => setAuthForm({ ...authForm, password: e.target.value })}
            />
            <button onClick={handleRegister}>Sign Up</button>
          </div>
          <div className="card">
            <h2>Login</h2>
            <input
              placeholder="Email"
              value={authForm.email}
              onChange={(e) => setAuthForm({ ...authForm, email: e.target.value })}
            />
            <input
              type="password"
              placeholder="Password"
              value={authForm.password}
              onChange={(e) => setAuthForm({ ...authForm, password: e.target.value })}
            />
            <button onClick={handleLogin}>Sign In</button>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="dashboard">
      <header>
        <h1>FinSight Dashboard</h1>
        <div>
          <span>Welcome, {user.name}</span>
          <button onClick={handleLogout}>Logout</button>
        </div>
      </header>

      <section className="summary-section">
        <div className="card">
          <h3>Total Income</h3>
          <p>₹ {summary?.totalIncome ?? 0}</p>
        </div>
        <div className="card">
          <h3>Total Expense</h3>
          <p>₹ {summary?.totalExpense ?? 0}</p>
        </div>
        <div className="card">
          <h3>Net Savings</h3>
          <p>₹ {summary?.netSavings ?? 0}</p>
        </div>
      </section>

      <section className="main-section">
        <div className="card">
          <h2>Add Transaction</h2>
          <div className="form-grid">
            <input
              type="number"
              placeholder="Amount"
              value={newTx.amount}
              onChange={(e) => setNewTx({ ...newTx, amount: Number(e.target.value) })}
            />
            <select
              value={newTx.type}
              onChange={(e) => setNewTx({ ...newTx, type: e.target.value as 'INCOME' | 'EXPENSE' })}
            >
              <option value="INCOME">Income</option>
              <option value="EXPENSE">Expense</option>
            </select>
            <select
              value={newTx.category}
              onChange={(e) => setNewTx({ ...newTx, category: e.target.value })}
            >
              <option value="FOOD">Food</option>
              <option value="RENT">Rent</option>
              <option value="TRAVEL">Travel</option>
              <option value="SHOPPING">Shopping</option>
              <option value="BILLS">Bills</option>
              <option value="OTHERS">Others</option>
            </select>
            <input
              type="date"
              value={newTx.date}
              onChange={(e) => setNewTx({ ...newTx, date: e.target.value })}
            />
            <input
              placeholder="Description"
              value={newTx.description}
              onChange={(e) => setNewTx({ ...newTx, description: e.target.value })}
            />
            <button onClick={handleAddTransaction}>Add</button>
          </div>
        </div>

        <div className="card">
          <h2>Spending by Category</h2>
          <div style={{ width: '100%', height: 250 }}>
            <ResponsiveContainer>
              <PieChart>
                <Pie data={byCategory} dataKey="value" nameKey="name" outerRadius={80} label>
                  {byCategory.map((entry, index) => (
                    <Cell key={`cell-${index}`} />
                  ))}
                </Pie>
                <Tooltip />
              </PieChart>
            </ResponsiveContainer>
          </div>
        </div>
      </section>

      <section className="transactions-section card">
        <h2>All Transactions</h2>
        <table>
          <thead>
            <tr>
              <th>Date</th>
              <th>Type</th>
              <th>Category</th>
              <th>Description</th>
              <th>Amount (₹)</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {transactions.map((tx) => (
              <tr key={tx.id}>
                <td>{tx.date}</td>
                <td>{tx.type}</td>
                <td>{tx.category}</td>
                <td>{tx.description}</td>
                <td>{tx.amount}</td>
                <td>
                  <button onClick={() => handleDeleteTransaction(tx.id)}>Delete</button>
                </td>
              </tr>
            ))}
            {transactions.length === 0 && (
              <tr>
                <td colSpan={6} style={{ textAlign: 'center' }}>
                  No transactions yet. Add your first one!
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </section>
    </div>
  );
};

export default App;
