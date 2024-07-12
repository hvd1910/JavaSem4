// src/components/CKEditorComponent.js
import React, { useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios';
import { ToastError, ToastSuccess } from '../notification';

const Createblog = () => {

  const userId = localStorage.getItem('user')

    const handleEditorChange = (event, editor) => {
        const data = editor.getData();
        setContent(data);
    };






    const [title, setTitle] = useState('');
  const [images, setImages] = useState(['']);
  const [description, setDescription] = useState('');
  const [content, setContent] = useState('');
  const [location, setLocation] = useState('');


  const handleTitleChange = (e) => {
    setTitle(e.target.value);
  };

  const handleLocationChange = (e) => {
    setLocation(e.target.value);
  };

  const handleImageChange = (index, event) => {
    const newImages = images.slice();
    newImages[index] = event.target.value;
    setImages(newImages);
  };

  const handleAddImage = () => {
    setImages([...images, '']);
  };

  const handleRemoveImage = (index) => {
    const newImages = images.slice();
    newImages.splice(index, 1);
    setImages(newImages);
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  const handleSubmit1 = (e) => {
    e.preventDefault();
    const postData = {
      name:title,
      description,
      content,
      location ,
      createdBy: userId
    };

    addblog(postData)

    async function addblog(blogdata) {
      try{
        const data = await axios.post(`http://localhost:8080/api/places`, blogdata) 
            console.log(data.data)
            if(data.data !== null) {
              const imagesdata= images.map(image => ({ image_path: image, place_id:  data.data.id}))
              console.log(imagesdata)
              ToastSuccess("Add Blog in successfully.")
            }
              
         
      }catch {
        ToastError("Please try again.")
      }
    }
    
    console.log(postData);
    // Handle form submission (e.g., send data to server)
  };
    return (
        <div>

<div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', height:'auto'}}>
      <h1>Create Blog Post</h1>
      <form onSubmit={handleSubmit1}>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Name</label>
          <input
            type="text"
            value={title}
            onChange={handleTitleChange}
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
            required
          />
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Location</label>
          <input
            type="text"
            value={location}
            onChange={handleLocationChange}
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
                value={image}
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
        <label style={{ display: 'block', marginBottom: '5px' }}>Content</label>

        <CKEditor
                    editor={ClassicEditor}
                    data=""
                    onChange={handleEditorChange}
                    config={{
                        ckfinder: {
                            uploadUrl: '/upload',
                        },
                        image: {
                            toolbar: [
                                'imageTextAlternative', '|',
                                'imageStyle:full', 'imageStyle:side'
                            ]
                        }
                    }}
                />
        <div>
          <button type="submit" style={{ padding: '8px 12px', marginTop:"16px" }}>Create Post</button>
        </div>
      </form>
    </div>
        </div>
    );
};

export default Createblog;
