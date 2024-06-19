import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Grid, Card, CardMedia, CardContent, Typography, Button, TextField } from '@mui/material';
import { useNavigate, useParams } from 'react-router';

import productImage from "../image/productImage.jpg";
import { ToastError, ToastSuccess } from '../componet/notification';

const Cart = () => {
    const { productId } = useParams();
    const [cartItems, setCartItems] = useState([]);
    const [successMessage, setSuccessMessage] = useState('');
    const navigate = useNavigate();



    const handleSubmit = (event) => {
		event.preventDefault();
	
		const data = new FormData(event.currentTarget);
		const Cartdata = {
			email: data.get("email"),
            price: cartItems.price,
            productId: cartItems.id
		};

        const createOrder = async (data) => {
            try {
                // Thay đổi URL backend của bạn để lấy danh sách sản phẩm từ giỏ hàng
                const response = await axios.post(`http://localhost:8088/orders`, data); 
                if(response.status === 200) {
                    navigate(`/customer/${response.data?.customer.id}`)
                    ToastSuccess("Đặt hàng thành công")
                    
                }else{
                    ToastError("Đặt hàng thất bại")
                }
            } catch (error) {
                ToastError("Đặt hàng thất bại")

            }
        };

        createOrder(Cartdata)
	  }




    useEffect(() => {
        const fetchCartItems = async () => {
            try {
                // Thay đổi URL backend của bạn để lấy danh sách sản phẩm từ giỏ hàng
                const response = await axios.get(`http://localhost:8088/products/${productId}`); 
                setCartItems(response.data); // Giả sử response.data là một mảng các sản phẩm trong giỏ hàng
            } catch (error) {
                console.error('Error fetching cart items: ', error);
            }
        };

        fetchCartItems();
    }, []);

    return (

        <Grid container spacing={3} justifyContent="center">
                <Grid item key={cartItems.id} xs={12} sm={6} md={4} lg={3}>
                <Card>
                    <CardMedia
                        component="img"
                        height="200"
                        image={productImage} // Thay đổi thành item.image hoặc item.imageUrl tương ứng
                        alt={cartItems.name}
                    />
                    <CardContent>
                        <Typography variant="h5" component="div" gutterBottom>
                            {cartItems.name}
                        </Typography>
                        <Typography variant="body1" color="text.secondary">
                            ${cartItems.price}
                        </Typography>
                      
                    </CardContent>
                </Card>
            </Grid>
            <Grid item key={cartItems.id} xs={12} sm={6} md={4} lg={4} >
                <Card style={{padding: "20px"}}>
                <form onSubmit={handleSubmit}  style={{ marginTop: '20px', textAlign: 'center' }} >
                <TextField
                    type="email"
                    name="email"
                    label="Email"
                    variant="outlined"
                    fullWidth
                   
                    style={{ marginBottom: '10px' }}
                />
                <br />
                <TextField
                    type="text"
                    name="name"
                    label="Name"
                    variant="outlined"
                    fullWidth
                  
                    style={{ marginBottom: '10px' }}
                />
                <br />
              

                <Button type="submit" variant="contained" color="primary">
                    Submit
                </Button>
            </form>
                </Card>
            </Grid>
        </Grid>
        

        
    );
};

export default Cart;
