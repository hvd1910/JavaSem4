import React from 'react'
import { useNavigate } from 'react-router'

const Navigation = () => {
    const navigate = useNavigate();
  return (
   
    <nav className="navbar navbar-area navbar-expand-lg has-topbar nav-style-01 index-01">
        <div className="container nav-container custom-header-container">
            <div className="responsive-mobile-menu">
                <div className="logo-wrapper">
                    <a href="index.html" className="logo">
                        <img src="https://bytesed.com/tf/ozagi/assets/img/logo/Logo-01.png" alt="logo"/>
                    </a>
                </div>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#bizcoxx_main_menu"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
            </div>
            <div className="collapse navbar-collapse" id="bizcoxx_main_menu">
                <ul className="navbar-nav">
                    <li className=" current-menu-item">
                        <a onClick={()=> navigate('/')}>Home</a>

                    </li>
                    <li className="">
                        <a onClick={()=> navigate('/blog')}>Blog</a>
                       
                    </li>
                    <li className="">
                        <a href="#">Gallery</a>
                       
                    </li>
                    <li className="menu-item-has-children">
                        <a href="#">pages</a>
                        <ul className="sub-menu">
                            <li><a href="about-author.html">About author</a></li>
                            <li><a href="search.html">search</a></li>
                            <li><a href="error-404.html">error</a></li>
                        </ul>
                    </li>
                    <li><a href="contact.html">contact us</a></li>

                    <li><a onClick={()=> navigate('/login')}>Login</a></li>

                </ul>
            </div>
            <div className="nav-right-content">
                <ul>
                    <li className="account">
                        <a href="#" id="search_icon">
                            <span className="text">search</span>
                            <i className="las la-search icon"></i>
                        </a>
                        <div className="search-popup" id="search_popup">
                            <div className="search-popup-inner">
                                <form action="index.html">
                                    <span className="search-popup-close-btn" id="search-popup-close-btn">×</span>
                                    <div className="form-group">
                                        <input type="text" className="form-control" placeholder="Search..."/>
                                    </div>
                                    <button className="search-btn" type="submit"><i className="fas fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  )
}

export default Navigation
