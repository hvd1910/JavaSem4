import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router';
import Home from './page/Home';
import ProductList from './page/ProductList';
import Cart from './page/Cart';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import CustomerDetail from './page/CustomerDetail';
import OrderDetail from './page/OrderDetail';



function App() {
  return (

    <div className="">
            <ToastContainer/>

      <Routes>
        <Route path='' element={<ProductList/>}/>
        <Route path='/cart/:productId' element={<Cart/>}/>
        <Route path='/customer/:customerId' element={<CustomerDetail/>}/>
        <Route path='/customer/order/:orderId' element={<OrderDetail/>}/>


      </Routes>
    </div>
  );
}

export default App;
