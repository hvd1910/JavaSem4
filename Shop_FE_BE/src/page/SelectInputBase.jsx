import axios from "axios";
import React, { Fragment, useEffect, useState } from "react";
import { ToastError, ToastSuccess } from "../componet/notification";
import { Navigate } from "react-router";

const SelectInputBase = ({ initialValue , idObject , onLoad}) => {
  const [selectedValue, setSelectedValue] = useState(initialValue);
  
  const handleOnChange = (event) => {
    const newValue = event.target.value;
    setSelectedValue(newValue)
    const UpdateStatusOrder = async (idObject, status) => {
      try {
          // Thay đổi URL backend của bạn để lấy danh sách sản phẩm từ giỏ hàng
          const response = await axios.put(`http://localhost:8088/orders/${idObject}?status=${status}`); 
          if(response.status === 200) {
              ToastSuccess("Cập nhật trạng thái thành công.")
              onLoad()
              
          }else{
              ToastError("Cập nhật đơn hàng thất bại")
          }
      } catch (error) {
        ToastError("Cập nhật đơn hàng thất bại")
      }

      
  };
  UpdateStatusOrder(idObject, newValue)
  };


  return (
      <select
        value={selectedValue !== undefined ? selectedValue : initialValue}
        name="status"
        className="form-select"
        onChange={(e) => handleOnChange(e)}
      >
        
            <option  value="pending">
              PENDING
            </option>
            <option  value="processing">
              PROCESSING
            </option>
            <option  value="shipping">
              SHIPPING
            </option>
            <option  value="delivered">
              DELIVERED
            </option>
          
      </select>
  );
};

export default SelectInputBase;
