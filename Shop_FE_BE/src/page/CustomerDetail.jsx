import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Grid, Card, CardContent, Typography, CircularProgress, Container, Paper, Box, Divider, Button } from '@mui/material';
import { useNavigate, useParams } from 'react-router-dom';

const CustomerDetail = () => {
    const { customerId } = useParams(); // Giả sử bạn lấy ID người dùng từ URL
    const [orders, setOrders] = useState([]);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get(`http://localhost:8088/orders/customer/${customerId}`);
                setOrders(response.data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching orders: ', error);
                setLoading(false);
            }
        };

        fetchOrders();
    }, [customerId]);

    if (loading) {
        return <CircularProgress />;
    }

    return (
        
            <Container maxWidth="lg">
              <Paper elevation={3} sx={{ p: 4 }}>
                <Typography variant="h5" gutterBottom>
                  Order History
                </Typography>
                {orders.map(order => (
                  <Box key={order.id} sx={{ mb: 2 }}>
                    <Grid container spacing={2}>
                      <Grid item xs={12} sm={2}>
                        <Typography variant="subtitle2" color="textSecondary">
                          Order ID
                        </Typography>
                        <Typography variant="body1">{order.id}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={3}>
                        <Typography variant="subtitle2" color="textSecondary">
                          Product
                        </Typography>
                        <Typography variant="body1">{order.product.name}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={2}>
                        <Typography variant="subtitle2" color="textSecondary">
                          Price
                        </Typography>
                        <Typography variant="body1">${order.price}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={2}>
                        <Typography variant="subtitle2" color="textSecondary">
                          Order Date
                        </Typography>
                        <Typography variant="body1">{new Date(order.orderDate).toLocaleDateString()}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={2}>
                        <Typography variant="subtitle2" color="textSecondary">
                          Status
                        </Typography>
                        <Typography variant="body1">{order.status}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={1}>
                       <Button variant="outlined" onClick={()=> navigate(`/customer/order/${order.id}`)} >View</Button>
                      </Grid>
                    </Grid>
                    <Divider sx={{ mt: 2 }} />
                  </Box>
                ))}
              </Paper>
            </Container>
    );
};

export default CustomerDetail;
