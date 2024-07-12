import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, RouterProvider } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';
import "./assets/css/bootstrap.min-v4.6.0.css"
import "./assets/css/fontawesome.all.min-v5.15.3.css"
import "./assets/css/line-awesome.min-v1.0.3.css"
import "./assets/css/animate.css"
import "./assets/css/magnific-popup.css"
import "./assets/css/main-style.css"
import "./assets/css/responsive.css"

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>  
  <App />
</BrowserRouter>  );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
