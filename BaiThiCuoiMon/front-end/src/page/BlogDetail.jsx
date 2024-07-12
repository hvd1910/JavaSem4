import React, {Fragment, useEffect, useState} from "react";
import SideBarTopBlog from "../componet/SideBarTopBlog/SideBarTopBlog";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";
import {ToastError, ToastSuccess} from "../componet/notification";
import axios from "axios";
import { useNavigate, useParams } from "react-router";



const dataBlog = {
  id: 1,
    title: 'Một bông hoa không thể nở nếu không có ánh nắng mặt trời, và một người không thể sống nếu không có tình yêu.',
  images: [
    {
      id: 1,
      image_url: "https://bytesed.com/tf/ozagi/assets/img/blog-details/01.jpg",
    },
    {
      id: 2,
      image_url: "https://bytesed.com/tf/ozagi/assets/img/blog-details/02.jpg",
    },
    {
      id: 3,
      image_url: "https://bytesed.com/tf/ozagi/assets/img/blog-details/03.jpg",
    },
    {
      id: 4,
      image_url: "https://bytesed.com/tf/ozagi/assets/img/blog-details/04.jpg",
    },
  ],
  description:     "Ulysses, Ulysses — Bay vút qua mọi thiên hà. Tìm kiếm Trái đất, bay vào màn đêm. Ulysses, Ulysses — Chiến đấu với cái ác và sự chuyên chế, bằng tất cả sức mạnh của mình, và bằng tất cả sức mạnh của mình. Ulysses — không ai khác có thể làm được những điều bạn làm. Ulysses — như một tia sét giữa trời xanh. Ulysses — luôn chiến đấu với mọi thế lực tà ác, mang lại hòa bình và công lý cho tất cả.\nKnight Rider, chuyến bay bí ẩn vào thế giới nguy hiểm của một người đàn ông không tồn tại. Michael Knight, một chàng trai trẻ cô đơn trong cuộc thập tự chinh để bảo vệ sự nghiệp của những người vô tội, những người bất lực trong một thế giới tội phạm hoạt động trên cả luật pháp.",
  guildes: '80 days around the world, we’ll find a pot of gold just sitting where the rainbow’s ending. Time — we’ll fight against the time, and we’ll fly on the white wings of the wind. 80 days around the world, no we won’t say a word before the ship is really back. Round, round, all around the world. Round, all around the world. Round, all around the world. Round, all around the world.Mutley, you snickering, floppy eared hound. When courage is needed, you’re never around. Those medals you wear on your moth-eaten chest should be there for bungling at which you are best. So, stop that pigeon, stop that pigeon, stop that pigeon, stop that pigeon, stop that pigeon, stop that pigeon, stop that pigeon. Howwww! Nab him, jab him, tab him',
  user: {
    id: 1,
    name: 'Phạm Hoa',
    description: 'Một người trong nước chuyển hướng tiên tiến lặp đi lặp lại mang đến cho bạn già. Có thể đã mua được tiếng cười tầm thường của cô ấy mặc dù.'
  },
  comments: [
    {
        id: 1,
        user_id: 1,
        name: 'Hồ việt đức',
        comment: 'Lời nói ngu ngốc của góa phụ một xuống vài tuổi mỗi bảy. Nếu bỏ lỡ một phần bởi thực tế anh ta chỉ cần cho thấy. Phát hiện đã được coi là dự đoán thuận lợi.',
        created_at: '20/06/2024'
    },
    {
        id: 2,
        user_id: 2,
        name: 'Phạm tuấn',
        comment: 'Lời nói ngu ngốc của góa phụ một xuống vài tuổi mỗi bảy. Nếu bỏ lỡ một phần bởi thực tế anh ta chỉ cần cho thấy. Phát hiện đã được coi là dự đoán thuận lợi.',
        created_at: '20/06/2024'

    },         
  ],
   created_at: '20/06/2024'
};



const BlogDetail = () => {

  const navigate = useNavigate()
  const { idBlog } = useParams()
  const [blog, setBlog] = useState([])
  const {load, setLoad} = useState(false)


  async function getBlog() {
  try{
    const response = await axios.get(`http://localhost:8080/api/places/${idBlog}`) 
    setBlog(response.data)

  }catch {
    
  }
}

useEffect(()=> {
  getBlog()
}, [load])


  const items = blog.images?.map((item) => (
    <img
      className="cursor-pointer"
      role="presentation"
      src={item.url}
      alt=""
    />
  ));

  const errorStyle = {
    fontSize: '12px',
    color: 'red',
  };

  // create form
   const [createForm, setcreateForm] = useState({
     id: 0,
     firstName: '',
     lastName: '',
     email: '',
     website: '',
     comments: ''
   });

   // error Form
  const [formErrors, setFormErrors] = useState({
    firstName: '',
    lastName: '',
    email: '',
    website: '',
    comments: ''
  })

  // validate form
  const validateForm = ()=>{
    const err = {};
    const REGEX_MAIL = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/
    let valid = true;
    if(createForm.firstName.trim() === ''){
      err.firstName = 'First Name is required';
      valid = false;
    }

    if(createForm.lastName.trim() === ''){
      err.lastName = 'Last Name is required';
      valid = false;
    }

    if(createForm.email.trim() === ''){
      err.email = 'Email is required';
      valid = false;
    } else if(!REGEX_MAIL.test(createForm.email.trim())){
      err.email = 'Please enter a valid email address';
      valid = false;
    }

    if(createForm.website.trim() === ''){
      err.website = 'Website is required';
      valid = false;
    }

    if(createForm.comments.trim() === ''){
      err.comments = 'Comments is required';
      valid = false;
    }
    setFormErrors(err);
    return valid;
  }

  const inputChange = (e) =>{
    setcreateForm({ ...createForm, [e.target.name]: e.target.value });
  };

   const postComment = async (e) =>{
     e.preventDefault();
     if(validateForm()) {
      const comment ={
        place_id: idBlog,
        comment: createForm.comments,
        rating: 5
      }
       clearForm();

      //  call api post comment
       try {
         const  response = await axios.post(`http://localhost:8080/api/comments/add/${idBlog}`, comment )
         clearForm();
         setLoad(!load)
         ToastSuccess("Thêm comment thành công")

       }catch{
       }
     }

  };

  const clearForm = () =>{
    setcreateForm({
      firstName: '',
      lastName: '',
      email: '',
      website: '',
      comments: ''
    })
  }


  return (
    <Fragment>
      {/* {/ <!-- breadcrumb area start --> /} */}
      <div class="breadcrumb-area">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="breadcrumb-inner">
                <h2 class="page-title">blog details</h2>
                <ul class="page-list">
                  <li class="list-item">
                    <a href="index.html">Home</a>
                  </li>
                  <li class="list-item">
                    <a href="#">blog details</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      {/* {/ <!-- breadcrumb area end --> /}

      {/ <!-- blog details area start --> /} */}
      <div class="blog-details-area-wrapper">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="single-box">
                <h4 class="title">
                  {blog?.name}
                </h4>
                <div class="img-box">
                  <AliceCarousel
                    items={items}
                    disableButtonsControls
                    autoPlay
                    autoPlayInterval={1500}
                    infinite
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-8">
              <div class="content contact-1">
                <div class="post-meta">
                  <ul class="list">
                    <li class="list-item">
                      <a href="#">
                        <i class="lar la-user icon"></i>
                        <span class="text">{blog?.name}</span>
                      </a>
                    </li>
                    <li class="list-item">
                      <a href="#">
                        <i class="lar la-clock icon"></i>
                        <span class="text">20/06/2024</span>
                      </a>
                    </li>
                    <li class="list-item">
                      <a href="#">
                        <i class="las la-tag icon"></i>
                        <span class="text">travel</span>
                      </a>
                    </li>
                  </ul>
                </div>
                <p class="info">
                 {blog?.description}
                </p>
                
              </div>

              <div>
                {blog?.content}
              </div>

              {/* {/ <!-- tag and social link area start --> /} */}
              <div class="blog-details-tag-icon">
                <div class="tag">
                  <p class="name">tags:</p>
                  <a href="#" class="tag-btn">
                    travel
                  </a>
                  <a href="#" class="tag-btn">
                    tour
                  </a>
                  <a href="#" class="tag-btn">
                    journey
                  </a>
                </div>
                <div class="icon">
                  <p class="name">share:</p>
                  <ul>
                    <li>
                      <a href="#">
                        <i class="lab la-facebook-f icon"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="lab la-twitter icon"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="lab la-pinterest-p icon"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="lab la-linkedin-in icon"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
              {/* {/ <!-- tag and social link area end --> /} */}

              {/* {/ <!-- comment area start --> /} */}
              <div class="comment-area">
                <div class="comment-pagination">
                  <ul class="pagination-main">
                    <li class="list">
                      <a href="#">
                        <i class="las la-arrow-left icon"></i>
                        Prev Post
                      </a>
                    </li>
                    <li class="list">
                      <a href="#">
                        Next Post
                        <i class="las la-arrow-right icon"></i>
                      </a>
                    </li>
                  </ul>
                </div>
                <h3 class="comment-section-title">{blog?.comments?.length} comments</h3>
                <ul class="comment-list">
                 {blog?.comments?.map((comment)=> (
                     <li>
                     <div class="single-comment-wrap">
                       <div class="thumb">
                         <img
                           src="https://bytesed.com/tf/ozagi/assets/img/blog-details/comment/03.jpg"
                           alt="image"
                         />
                       </div>
                       <div class="content">
                         <div class="content-top">
                           <div class="left">
                             <h4 class="title">Anonymous</h4>
                             <ul class="post-meta">
                               <li class="meta-item">
                                 <a href="#">
                                   <i class="las la-calendar icon"></i>
                                   7/12/2024
                                 </a>
                               </li>
                             </ul>
                           </div>
                           <div class="right">
                             <a href="#" class="reply-btn">
                               <i class="las la-reply"></i> 
                             </a>
                           </div>
                         </div>
                         <p class="comment">
                           {comment.comment}
                         </p>
                       </div>
                     </div>
                   </li>
                 )) }
                  
                  
                </ul>

                {/* {/ <!-- comment form area start --> /} */}
                <div class="comment-form-area">
                  <h3 class="comment-section-title">post your comment</h3>

                  <form action="blog-details.html" class="comment-form">
                    <div class="row">
                      <div class="col-lg-6">
                        <div class="form-group">
                          <input
                              type="text"
                              class="form-control"
                              placeholder="First Name"
                              name="firstName"
                              required=""
                              value={createForm.firstName}
                              onChange={inputChange}
                          />
                              <span style={errorStyle}>{formErrors.firstName}</span>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="form-group">
                          <input
                              type="text"
                              class="form-control"
                              placeholder="Last Name"
                              name="lastName"
                              required=""
                              value={createForm.lastName}
                              onChange={inputChange}
                          />
                          <span style={errorStyle}>{formErrors.lastName}</span>
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="form-group">
                          <input
                              type="input"
                              class="form-control"
                              placeholder="Email"
                              name="email"
                              required=""
                              value={createForm.email}
                              onChange={inputChange}
                          />
                          <span style={errorStyle}>{formErrors.email}</span>

                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="form-group">
                          <input
                              type="url"
                              class="form-control"
                              placeholder="Website"
                              name="website"
                              required=""
                              value={createForm.website}
                              onChange={inputChange}
                          />
                          <span style={errorStyle}>{formErrors.website}</span>

                        </div>
                      </div>
                      <div class="col-lg-12">
                        <div class="form-group">
                          <textarea
                              id="message"
                              class="form-control"
                              placeholder="Comments"
                              name="comments"
                              cols="30"
                              rows="10"
                              value={createForm.comments}
                              onChange={inputChange}
                          ></textarea>
                          <span style={errorStyle}>{formErrors.comments}</span>

                        </div>
                      </div>
                      <div class="col-lg-12">
                      <div class="btn-wrapper">
                          <button onClick={ postComment } type="submit" class="btn-default">
                            Post Comment
                          </button>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
                {/* {/ <!-- comment form area end --> /} */}
              </div>
              {/* {/ <!-- comment area end --> /} */}
            </div>
            <SideBarTopBlog />
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default BlogDetail;
