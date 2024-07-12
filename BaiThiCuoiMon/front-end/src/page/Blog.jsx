import axios from 'axios'
import React, { Fragment, useEffect, useState } from 'react'
import { useNavigate } from 'react-router'




const Blog = () => {
    const navigate = useNavigate()
    const [blogs, setBlogs] = useState([])


    async function getBlog() {
    try{
      const response = await axios.get(`http://localhost:8080/api/places`) 
      setBlogs(response.data)

    }catch {
      
    }
  }


  useEffect(()=> {
    getBlog()
  }, [])
  return (
    <Fragment>
    <div className="breadcrumb-area">
        <div className="container">
            <div className="row">
                <div className="col-lg-12">
                    <div className="breadcrumb-inner">
                        <h2 className="page-title">Travel Blog</h2>
                        <ul className="page-list">
                            <li className="list-item"><a onClick={()=> navigate('/')}>Home</a></li>
                            <li className="list-item"><a onClick={()=> navigate('/blog')}>Travel Blog</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div className="traver-blog-grid-wrapper">
        <div className="container">
            <div className="row">
               {blogs.map((blog)=> (
                 <div className="col-lg-6" onClick={()=> (navigate(`/blog/${blog.id}`))}>
                 <div className="single-blog-list-1-index-1 single-grid travel">
                     <div className="content-top">
                         <h2 className="title">
                             <a onClick={()=> (navigate(`/blog/${blog.id}`))}></a>
                         </h2>
                         <div className="img-box">
                             <img src={blog?.images[0]?.url} alt="image"/>
                         </div>
                         <div className="content-bottom">
                             <p className="info">{blog.name} </p>
                             <div className="post-meta">
                                 <ul className="list">
                                     
                                     <li className="list-item">
                                         <a onClick={()=> (navigate(`/blog/${blog.id}`))}>
                                             <i className="far fa-clock icon"></i>
                                             <span className="text">june 19, 2024</span>
                                         </a>
                                     </li>
                                     <li className="list-item">
                                         <a onClick={()=> (navigate(`/blog/${blog.id}`))}>
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
                
            </div>
            <div className="row">
                <div className="col-lg-12">
                    <div className="pagination">
                        <ul className="pagination-list m-auto">
                            <li><a href="#" className="page-number"><i className="fas fa-angle-left"></i></a></li>
                            <li><span className="page-number current">1</span></li>
                            <li><a href="#" className="page-number">2</a></li>
                            <li><a href="#" className="page-number">3</a></li>
                            <li><a href="#" className="page-number"><i className="fas fa-angle-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </Fragment>
  )
}

export default Blog
