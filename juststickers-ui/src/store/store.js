import { configureStore } from "@reduxjs/toolkit";
import cartReducer from "./cart-slice";
const store = configureStore({
  reducer: {
    cart: cartReducer,
  },
});
export default store;

store.subscribe(() => {
  console.log("Store updated:", store.getState());
  localStorage.setItem("cart", JSON.stringify(store.getState().cart));
});
