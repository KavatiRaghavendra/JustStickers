export default function PageHeading({ title, children }) {
  return (
    <div className="mb-8 text-center">
      <h2 className="text-3xl font-bold mb-4">{title}</h2>
      <p className="text-gray-600">{children}</p>
    </div>
  );
}
