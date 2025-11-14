import PageHeading from "./PageHeading.jsx";
export default function Home() {
  return (
    <>
      <div className=" bg-cover bg-center dark:bg-darkbg">
        <div className="max-w-[1152px] mx-auto px-6 py-8 dark:text-gray-200 text-gray-800 dark:bg-darkbg">
          <PageHeading title="Explore Just Stickers!">
            Add a touch of creativity to your space with our wide range of fun
            and unique stickers. Perfect for any occasion!
          </PageHeading>
        </div>
      </div>
    </>
  );
}
