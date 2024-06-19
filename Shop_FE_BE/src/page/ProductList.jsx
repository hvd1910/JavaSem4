import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {Button} from '@mui/material'
import {  Listbox } from '@headlessui/react';
import { ChevronDownIcon } from '@heroicons/react/solid';
import productImage from "../image/productImage.jpg"
import { Card, CardContent, CardMedia, Grid, Typography } from '@mui/material';
import { useNavigate } from 'react-router';

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const navigate = useNavigate()

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await axios.get('http://localhost:8088/products'); // Thay đổi URL backend của bạn tại đây
                setProducts(response.data);
            } catch (error) {
                console.error('Error fetching products: ', error);
            }
        };

        fetchProducts();
    }, []);

    return (

        <Grid container spacing={3} justifyContent="center">
        {products.map(product => (
            <Grid item key={product.id} xs={12} sm={6} md={4} lg={3}>
                <Card className="max-w-xs">
                    <CardMedia
                        component="img"
                        height="200"
                        image={productImage} // Thay đổi thành URL hình ảnh sản phẩm
                        alt={product.name}
                    />
                    <CardContent>
                        <Typography variant="h5" component="div" gutterBottom>
                            {product.name}
                        </Typography>
                        <Typography variant="body1" color="text.secondary">
                            ${product.price}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            {product.description}
                        </Typography>
                        <Button variant="contained" color="primary" fullWidth onClick={()=> navigate(`/cart/${product.id}`)}>
                            Add to Cart
                        </Button>
                    </CardContent>
                </Card>
            </Grid>
        ))}
    </Grid>
    );
};

export default ProductList;
