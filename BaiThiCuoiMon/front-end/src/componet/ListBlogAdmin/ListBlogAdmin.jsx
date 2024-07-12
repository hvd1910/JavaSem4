import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router';

const ListBlogAdmin = () => {
    const [posts, setPosts] = useState([]);
      const navigate = useNavigate()
  
  
      async function getBlog() {
      try{
        const response = await axios.get(`http://localhost:8080/api/places`) 
        setPosts(response.data)
  
      }catch {
        
      }
    }
  
  
    useEffect(()=> {
      getBlog()
    }, [])
      const [editingPost, setEditingPost] = useState(null);
      const [name, setName] = useState('');
      const [images, setImages] = useState([{ url: '' }]);
      const [description, setDescription] = useState('');
    
      const startEditing = (post) => {
        setEditingPost(post.id);
        setName(post.name);
        setImages(post.images);
        setDescription(post.description);
      };
    
      const handleTitleChange = (e) => {
        setName(e.target.value);
      };
    
      const handleImageChange = (index, event) => {
        const newImages = images.slice();
        newImages[index].url = event.target.value;
        setImages(newImages);
      };
    
      const handleAddImage = () => {
        setImages([...images, { url: '' }]);
      };
    
      const handleRemoveImage = (index) => {
        const newImages = images.slice();
        newImages.splice(index, 1);
        setImages(newImages);
      };
    
      const handleDescriptionChange = (e) => {
        setDescription(e.target.value);
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        const updatedPost = {
          id: editingPost,
          name,
          images,
          description,
        };

        console.log(updatedPost)
        setPosts(posts.map(post => post.id === editingPost ? updatedPost : post));
        setEditingPost(null);
        setName('');
        setImages([{ url: '' }]);
        setDescription('');
      };
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', }}>
    <div style={{display: 'flex', justifyContent:'space-around'}}>
    <h1>Manage Blog Posts </h1>
    <button onClick={()=> navigate('/admin/blog/add')} style={{ padding: '8px 12px', marginTop: '10px' }}>
            Add Image
          </button>
    </div>
    <div>
      {posts.map(post => (
        <div key={post.id} style={{ marginBottom: '15px', border: '1px solid #ccc', padding: '10px' }}>
          <h2>{post.name}</h2>
          <p>{post.description}</p>
          <button onClick={() => startEditing(post)}>Edit</button>
        </div>
      ))}
    </div>
    {editingPost && (
      <form onSubmit={handleSubmit} style={{ marginTop: '20px' }}>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Name</label>
          <input
            type="text"
            value={name}
            onChange={handleTitleChange}
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
            required
          />
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Images</label>
          {images.map((image, index) => (
            <div key={index} style={{ display: 'flex', alignItems: 'center', marginBottom: '5px' }}>
              <input
                type="text"
                value={image.url}
                onChange={(e) => handleImageChange(index, e)}
                style={{ flex: 1, padding: '8px', boxSizing: 'border-box' }}
                placeholder="Enter image URL"
                required
              />
              <button type="button" onClick={() => handleRemoveImage(index)} style={{ marginLeft: '10px', padding: '8px 12px' }}>
                Remove
              </button>
            </div>
          ))}
          <button type="button" onClick={handleAddImage} style={{ padding: '8px 12px', marginTop: '10px' }}>
            Add Image
          </button>
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Description</label>
          <textarea
            value={description}
            onChange={handleDescriptionChange}
            rows="5"
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
            required
          ></textarea>
        </div>
        <div>
          <button type="submit" style={{ padding: '8px 12px' }}>Update Post</button>
        </div>
      </form>
    )}
  </div>
  )
}

export default ListBlogAdmin
