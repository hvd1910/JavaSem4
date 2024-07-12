import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router';
import Home from './page/Home';
import { ToastContainer } from 'react-toastify';
import Navigation from './componet/Navigation/Navigation'
import Footer from './componet/Footer/Footer'
import Blog from './page/Blog';
import BlogDetail from './page/BlogDetail';
import Createblog from './componet/Createblog/Createblog';
import ListBlogAdmin from './componet/ListBlogAdmin/ListBlogAdmin';
import Login from './componet/Login/Login';




function App() {
  return (

    <div className="">
            <ToastContainer/>

      <Navigation/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/blog' element={<Blog/>}/>
        <Route path='/blog/:idBlog' element={<BlogDetail/>}/>
        <Route path='/admin/blog/add' element={<Createblog/>}/>
        <Route path='/admin/blog' element={<ListBlogAdmin/>}/>
        <Route path='/login' element={<Login/>}/>

      </Routes>
     
     <Footer/>
    </div>
    
  );
}

export default App;
