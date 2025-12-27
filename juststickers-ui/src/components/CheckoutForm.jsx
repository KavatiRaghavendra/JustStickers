import PageTitle from "./PageTitle";
import { Form } from "react-router-dom";
import apiClient from "../api/apiClient";
import { useActionData, useNavigate, useNavigation } from "react-router-dom";
import { use, useEffect } from "react";
import { toast } from "react-toastify";
import { useAuth } from "../store/auth-context";
import { useLoaderData } from "react-router-dom";
import { useState } from "react";
import { useSelector } from "react-redux";
import { selectTotalPrice, selectCartItems } from "../store/cart-slice";
import { useDispatch } from "react-redux";
import { clearCart } from "../store/cart-slice";
export default function CheckoutForm() {
  const labelStyle =
    "block text-lg font-semibold text-primary dark:text-light mb-2";
  const h2Style =
    "block text-2xl font-semibold text-primary dark:text-light mb-2";
  const textFieldStyle =
    "w-full px-4 py-2 text-base border rounded-md transition border-primary dark:border-light focus:ring focus:ring-dark dark:focus:ring-lighter focus:outline-none text-gray-800 dark:text-lighter bg-white dark:bg-gray-600 placeholder-gray-400 dark:placeholder-gray-300";
  const { isAuthenticated, user } = useAuth();
  useEffect(() => {
    if (!isAuthenticated) {
      toast.error("Please log in to proceed to checkout.");
      navigate("/login");
    }
  }, [isAuthenticated]);
  const dispatch = useDispatch();
  const initialProfileData = useLoaderData();
  const actionData = useActionData();
  const navigation = useNavigation();
  const navigate = useNavigate();
  const isSubmitting = navigation.state === "submitting";
  //const { cart } = useCart();
  const [profileData, setProfileData] = useState(initialProfileData);
  const cart = useSelector(selectCartItems);

  const subtotal = cart
    .reduce((acc, item) => acc + item.price * item.quantity, 0)
    .toFixed(2);

  useEffect(() => {
    if (actionData?.success) {
      dispatch(clearCart());
      toast.success(actionData.message || "Order placed successfully!");
      navigate("/OrderSuccess");
    }
  }, [actionData, navigate]);

  return (
    <div className="min-h-screen bg-normalbg py-8 px-4 dark:bg-darkbg  ">
      <PageTitle title="Checkout" />
      <div className="max-w-2xl mx-auto bg-white dark:bg-darkbg rounded-lg shadow-md p-6 dark:text-gray-200  ">
        <h2 className="text-2xl font-semibold mb-6 text-gray-800 dark:text-gray-200">
          Checkout Form
        </h2>
        <Form method="post" className="space-y-6 max-w-[768px] mx-auto ">
          <div className="mb-4">
            <input type="hidden" name="subtotal" value={subtotal} />

            <label
              htmlFor="name"
              className="block text-gray-700 dark:text-gray-300 font-medium mb-2"
            >
              Full Name
            </label>
            <input
              type="text"
              id="name"
              name="name"
              readOnly={true}
              required
              value={user.name}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary dark:bg-darkbg dark:border-gray-600 dark:text-gray-200"
              placeholder="Enter your full name"
            />
            {actionData?.errors?.name && (
              <p className="text-red-500 text-sm mt-1">
                {actionData.errors.name}
              </p>
            )}
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
            <div className="mb-4">
              <label
                htmlFor="email"
                className="block text-gray-700 dark:text-gray-300 font-medium mb-2"
              >
                Email Address
              </label>
              <input
                type="email"
                id="email"
                name="email"
                required
                readOnly={true}
                value={user.email}
                className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary dark:bg-darkbg dark:border-gray-600 dark:text-gray-200"
                placeholder="Enter your email address"
              />
              {actionData?.errors?.email && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.email}
                </p>
              )}
            </div>
            <div className="mb-4">
              <label
                htmlFor="phone"
                className="block text-gray-700 dark:text-gray-300 font-medium mb-2"
              >
                Phone Number
              </label>
              <input
                type="tel"
                id="phone"
                required
                readOnly={true}
                name="mobileNumber"
                value={user.mobileNumber}
                className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-primary dark:bg-darkbg dark:border-gray-600 dark:text-gray-200"
                placeholder="Enter your phone number"
              />
              {actionData?.errors?.mobileNumber && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.mobileNumber}
                </p>
              )}
            </div>
          </div>
          <div>
            <h2 className={h2Style}>Address Details</h2>
            <label htmlFor="street" className={labelStyle}>
              Street
            </label>
            <input
              id="street"
              name="street"
              type="text"
              readOnly={true}
              placeholder="Street details"
              value={profileData.address?.street}
              className={textFieldStyle}
              required
              minLength={5}
              maxLength={30}
            />
            {actionData?.errors?.street && (
              <p className="text-red-500 text-sm mt-1">
                {actionData.errors.street}
              </p>
            )}
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
            <div>
              <label htmlFor="city" className={labelStyle}>
                City
              </label>
              <input
                id="city"
                name="city"
                type="text"
                readOnly={true}
                placeholder="Your City"
                value={profileData.address?.city}
                onChange={(e) =>
                  setProfileData((prev) => ({
                    ...prev,
                    address: {
                      ...prev.address,
                      city: e.target.value,
                    },
                  }))
                }
                className={textFieldStyle}
                required
                minLength={3}
                maxLength={30}
              />
              {actionData?.errors?.city && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.city}
                </p>
              )}
            </div>

            <div>
              <label htmlFor="state" className={labelStyle}>
                State
              </label>
              <input
                id="state"
                name="state"
                type="text"
                readOnly={true}
                required
                minLength={2}
                maxLength={30}
                placeholder="Your State"
                value={profileData.address?.state}
                onChange={(e) =>
                  setProfileData((prev) => ({
                    ...prev,
                    address: {
                      ...prev.address,
                      state: e.target.value,
                    },
                  }))
                }
                className={textFieldStyle}
              />
              {actionData?.errors?.state && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.state}
                </p>
              )}
            </div>
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
            <div>
              <label htmlFor="postalCode" className={labelStyle}>
                Postal Code
              </label>
              <input
                id="postalCode"
                name="postalCode"
                readOnly={true}
                type="text"
                placeholder="Your Postal Code"
                value={profileData.address?.postalCode}
                onChange={(e) =>
                  setProfileData((prev) => ({
                    ...prev,
                    address: {
                      ...prev.address,
                      postalCode: e.target.value,
                    },
                  }))
                }
                className={textFieldStyle}
                required
                pattern="^\d{5}$"
                title="Postal code must be exactly 5 digits"
              />
              {actionData?.errors?.postalCode && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.postalCode}
                </p>
              )}
            </div>

            <div>
              <label htmlFor="country" className={labelStyle}>
                Country
              </label>
              <input
                id="country"
                name="country"
                type="text"
                required
                minLength={2}
                maxLength={2}
                placeholder="Your Country"
                value={profileData.address?.country}
                onChange={(e) =>
                  setProfileData((prev) => ({
                    ...prev,
                    address: {
                      ...prev.address,
                      country: e.target.value,
                    },
                  }))
                }
                className={textFieldStyle}
              />
              {actionData?.errors?.country && (
                <p className="text-red-500 text-sm mt-1">
                  {actionData.errors.country}
                </p>
              )}
            </div>
          </div>
          <div className="mt-6">
            <h2 className={h2Style}>Note</h2>
            <p className="text-red-500">
              * All payments are currently set to Cash on Delivery (COD) only.
            </p>
            <p className="text-red-500">
              * Address fields are read-only. To update your address, please go
              to your Profile page.
            </p>
          </div>

          <div>
            <h2 className={h2Style}>Payment Method</h2>
            <label className="inline-flex items-center">
              <input
                type="radio"
                name="payment"
                value="cod"
                defaultChecked
                className="form-radio text-primary dark:text-light"
              />
              <span className="ml-2 text-gray-700 dark:text-gray-300">
                Cash on Delivery (COD)
              </span>
            </label>
          </div>
          <button
            type="submit"
            disabled={isSubmitting}
            className="w-full bg-primary text-white py-2 px-4 rounded-md hover:bg-primarydark transition-colors duration-300"
          >
            {isSubmitting ? "Ordering...$" : "Place Order Now - $" + subtotal}
          </button>
        </Form>
      </div>
    </div>
  );
}

export async function checkoutAction({ request }) {
  const data = await request.formData();
  const cart = JSON.parse(localStorage.getItem("cart") || "[]");
  // const checkoutData = {
  //   name: data.get("name"),
  //   email: data.get("email"),
  //   mobileNumber: data.get("mobileNumber"),
  //   address: {
  //     line1: data.get("street"),
  //     city: data.get("city"),
  //     state: data.get("state"),
  //     postal_code: data.get("postalCode"),
  //     country: data.get("country"),
  //   },
  //   payment: data.get("payment"),
  // };
  const checkoutData = {
    totalPrice: data.get("subtotal"),
    paymentId: "COD+" + new Date().getTime() + data.get("mobileNumber"),
    paymentStatus: "Done",
    items: cart.map((item) => ({
      productId: item.productId,
      quantity: item.quantity,
      price: item.price,
    })),
  };
  try {
    const response = await apiClient.post("/orders", checkoutData);
    return { success: true, message: "Order placed successfully!" };
  } catch (error) {
    if (error.response?.status === 400) {
      return { success: false, errors: error.response?.data };
    }
    throw new Response(
      error.response?.data?.errorMessage ||
        error.message ||
        "An unexpected error occurred during checkout.",
      { status: error.status || 500 }
    );
  }
}

export async function checkoutprofileLoader() {
  try {
    const response = await apiClient.get("/profile"); // Axios GET Request
    return response.data;
  } catch (error) {
    throw new Response(
      error.response?.data?.errorMessage ||
        error.message ||
        "Failed to fetch Address details. Please try again.",
      { status: error.status || 500 }
    );
  }
}
