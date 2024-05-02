const BASE_URL = "http://localhost:8000";


export const ClientServiceUrls = {
  GET_CUSTOMER_BY_USER_NAME : BASE_URL + "/client/getcustomerbyusername"
}
// Security Service 
export const AuthenticationUrls = {
  REGISTER_USER : BASE_URL + "/auth/register",
  LOGIN : BASE_URL + "/auth/token",
  CHECK_IS_LOGGEDIN: BASE_URL + "/auth/validate",
  GET_CUSTOMER_BY_USER_NAME : BASE_URL + "/client/getcustomerbyusername",
}

export const ProductServiceUrls = {
  UPLOAD : BASE_URL + "/product/upload",
  CREATE_PRODUCT : BASE_URL + "/product/create",
  UPDATE_PRODUCT : BASE_URL + "/product/update",
  DELETE_PRODUCT : BASE_URL + "/product/delete",
  GET_ALL_PRODUCT : BASE_URL + "/product/getall",
  GET_PRODUCT_BY_ID : BASE_URL + "/product",
};

export const OrderServiceUrls = {
  CREATE_ORDER : BASE_URL + "/order",
  UPDATE_ORDER : BASE_URL + "/order/update",
  GET_ALL_ORDER : BASE_URL + "/order/getall",
  GET_ALL_ORDER_BY_CUSTOMER : BASE_URL + "/order/getallbyuser",
  GET_ALL_ORDER_BY_STATUS : BASE_URL + "/order/getallbystatus",
  GET_ORDER_BY_ID : BASE_URL + "/order/cart/getbyid",
  CREATE_CART : BASE_URL + "/order/cart/create",
  GET_ALL_CART_BY_CUSTOMER : BASE_URL + "/order/cart/getall"
};

export const CartServiceUrls = {
  ADD_TO_CART : BASE_URL + "/order/cart/create",
  GET_CART_LIST : BASE_URL + "/order/cart/getall"
};


