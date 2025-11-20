import axios from "axios";

const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL,
  headers: {
    "Content-Type": "application/json", // This ensures data is sent as JSON
  },
  timeout: 10000,
});

export default apiClient;
