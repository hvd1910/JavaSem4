import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import {
  Container,
  Paper,
  Grid,
  Typography,
  CircularProgress,
  Box,
  Divider
} from '@mui/material';

const OrderDetail = () => {
  const { orderId } = useParams();
  const [order, setOrder] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchOrderDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:8088/orders/${orderId}`);
        setOrder(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching order details: ', error);
        setLoading(false);
      }
    };

    fetchOrderDetails();
  }, [orderId]);

  if (loading) {
    return (
      <Box display="flex" justifyContent="center" alignItems="center" height="100vh">
        <CircularProgress />
      </Box>
    );
  }

  if (!order) {
    return <Typography variant="h6">Order not found.</Typography>;
  }

  return (
    <Container maxWidth="md" style={{marginTop: "40px"}}>
      <Paper elevation={3} sx={{ p: 4 }}>
        <Typography variant="h5" gutterBottom>
          Order Details
        </Typography>
        <Box sx={{ mb: 2 }}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Order ID
              </Typography>
              <Typography variant="body1">{order.id}</Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Product
              </Typography>
              <Typography variant="body1">{order.product.name}</Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Price
              </Typography>
              <Typography variant="body1">${order.price}</Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Order Date
              </Typography>
              <Typography variant="body1">{new Date(order.orderDate).toLocaleDateString()}</Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Status
              </Typography>
              <Typography variant="body1">{order.status}</Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="subtitle2" color="textSecondary">
                Customer
              </Typography>
              <Typography variant="body1">{order.customer.name}</Typography>
            </Grid>
          </Grid>
          <Divider sx={{ mt: 2 }} />
          <Typography variant="h6" sx={{ mt: 2 }}>
            Shipping Details
          </Typography>
          <Typography variant="body1">{order.customer.name}</Typography>
          <Typography variant="body1">{order.customer.email}</Typography>
        </Box>
      </Paper>
    </Container>
  );
};

export default OrderDetail;
