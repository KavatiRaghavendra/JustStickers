export default function Message({ message }) {
  return (
    <div className="max-w-2xl mx-auto p-4 bg-white dark:bg-gray-800 rounded-lg shadow-md">
      <p className="text-gray-800 dark:text-gray-200">{message}</p>
    </div>
  );
}
