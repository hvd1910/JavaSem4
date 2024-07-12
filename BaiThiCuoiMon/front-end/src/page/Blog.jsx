import axios from 'axios'
import React, { Fragment, useEffect, useState } from 'react'
import { useNavigate } from 'react-router'


const dataBlogs = [
    {
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
    },
    {
        id: 2,
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
    },
    {
        id: 3,
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
    }
]

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
                             <img src={blog?.images[0].url} alt="image"/>
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
