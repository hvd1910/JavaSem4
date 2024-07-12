import React, { Fragment, useEffect, useState } from 'react'
import SideBarTopBlog from '../componet/SideBarTopBlog/SideBarTopBlog'
import { useNavigate } from 'react-router'
import axios from 'axios'







const Home = () => {
    const navigate = useNavigate()
    const [blog, setBlog] = useState([])


    async function getBlog() {
    try{
      const response = await axios.get(`http://localhost:8080/api/places`) 
      setBlog(response.data)

    }catch {
      
    }
  }


  useEffect(()=> {
    getBlog()
  }, [])
  return (
    <Fragment>
      


    <div className="header-area-wrapper index-01">
        <div className="header-area index-01 header-slider-init">
            <div className="single-slid-item">
                <div className="container custom-header-container bg"
                    style={{ backgroundImage: `url(${blog[0]?.images[0].url})` }}
>
                    <div className="row h-100">
                        <div className="col-lg-12 position-relative h-100">
                            <div className="content">
                                <span className="first-word space-style">travel</span>
                                <h1 className="header-title">{blog[0]?.name} </h1>
                                <div className="btn-wrapper">
                                    <a onClick={()=> navigate(`/blog/${blog[0]?.id}`)} className="btn-default">read more</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
    </div>

    <div className="blog-list-area-wrapper index-01">
        <div className="container custom-container-1515">
            <div className="row">
                <div className="col-lg-8 col-xl-9">
                    {blog?.map((item)=> (
                        <div className="single-blog-list-1-index-1 wow bounceInUp" data-wow-duration="1.8s">
                        <div className="content-top">
                            <span className="first-word space-style">travel</span>
                            <h2 className="title">
                                <a onClick={()=> navigate(`/blog/${item.id}`)}>{item.name}</a>
                            </h2>
                            <div className="img-box">
                                <img src={item.images[0].url} alt="image"/>
                            </div>
                            <div className="content-bottom">
                                <p className="info">{item.description} </p>
                                <div className="post-meta">
                                    <div className="left-content">
                                        <div className="btn-wrapper">
                                            <a onClick={()=>navigate(`/blog/${item.id}`)} className="reading-btn">continue reading</a>
                                        </div>
                                    </div>
                                    <div className="right-content">
                                        <ul className="list">
                                           
                                            <li className="list-item">
                                                <a href="#">
                                                    <i className="far fa-clock icon"></i>
                                                    <span className="text">june 19, 2024</span>
                                                </a>
                                            </li>
                                            <li className="list-item">
                                                <a href="#">
                                                    <i className="far fa-share-square icon"></i>
                                                    <span className="text">share</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    ))}
                  
                    <div className="pagination">
                        <ul className="pagination-list">
                            <li><a href="#" className="page-number"><i className="fas fa-angle-left"></i></a></li>
                            <li><span className="page-number current">1</span></li>
                            <li><a href="#" className="page-number">2</a></li>
                            <li><a href="#" className="page-number">3</a></li>
                            <li><a href="#" className="page-number"><i className="fas fa-angle-right"></i></a></li>
                        </ul>
                    </div>
                </div>
                <SideBarTopBlog/>
            </div>
        </div>
    </div>


    
    </Fragment>
  )
}

export default Home
