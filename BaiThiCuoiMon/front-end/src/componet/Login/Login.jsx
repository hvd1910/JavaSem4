import React from 'react'
import { ToastError, ToastSuccess } from '../notification';
import { useNavigate } from 'react-router';
import axios from 'axios';

const Login = () => {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const data = new FormData(event.currentTarget);
    const userData = {
      username: data.get("username"),
      password: data.get("password")
    };
    loginAdmin(userData)
  }
    async function loginAdmin(userData) {
      try{
        const data = await axios.post(`http://localhost:8080/api/login`, userData) 
            console.log(data.data)
              localStorage.setItem("user", data.data.id)
              ToastSuccess("Login in successfully.")
              navigate('/admin')
         
      }catch {
        ToastError("Please try again.")
      }
    }
  
  return (
    <div className=''>
      <form className='m-5' onSubmit={handleSubmit}>
  <div class="mb-3 ">
    <label for="exampleInputEmail1" class="form-label">UserName</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name='username'/>
    <div id="emailHelp" class="form-text">We'll never share your username with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label" >Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name='password'/>
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
  )
}

export default Login
