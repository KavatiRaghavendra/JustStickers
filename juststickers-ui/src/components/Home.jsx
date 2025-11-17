import PageHeading from "./PageHeading.jsx";
import ProductListings from "./ProductListings.jsx";
import { useLoaderData } from "react-router-dom";
import apiClient from "../api/apiClient";
export default function Home() {
  const products = useLoaderData();
  return (
    <>
      <div className=" bg-cover bg-center dark:bg-darkbg">
        <div className=" mx-auto px-6 py-8 bg-cover bg-normalbg dark:text-gray-200 text-gray-800 dark:bg-darkbg">
          <PageHeading title="Explore Just Stickers!">
            Add a touch of creativity to your space with our wide range of fun
            and unique stickers. Perfect for any occasion!
          </PageHeading>
        </div>
        <ProductListings products={products} />
      </div>
    </>
  );
}

export async function productsLoader() {
  try {
    const response = await apiClient.get("/products"); // Axios GET Request
    return response.data;
  } catch (error) {
    throw new Response(
      error.response?.data?.errorMessage ||
        error.message ||
        "Failed to fetch products. Please try again.",
      { status: error.status || 500 }
    );
  }
}
