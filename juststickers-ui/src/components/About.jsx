import React from "react";
import PageTitle from "./PageTitle.jsx";

export default function About() {
  return (
    <div className="flex flex-col min-h-[980px]">
      <main className="flex-grow">
        <div className="py-12 bg-normalbg dark:bg-darkbg font-primary">
          <div className="max-w-4xl mx-auto px-4">
            <PageTitle title="About JustStickers" />
          </div>
          <div className="text-center text-gray-600 dark:text-lighter flex flex-col items-center">
            <p className="max-w-[576px] px-2 mx-auto leading-6 mb-4">
              JustStickers is your one-stop destination for high-quality,
              affordable stickers that let you express yourself in style.
              Whether you're looking to personalize your laptop, decorate your
              water bottle, or add some flair to your notebooks, we've got you
              covered. Our extensive collection features a wide range of
              designs, from trendy and modern to classic and quirky, ensuring
              there's something for everyone. At JustStickers, we believe that
              stickers are more than just decorations – they're a way to
              showcase your personality and make everyday items uniquely yours.
              Explore our selection today and find the perfect stickers to
              brighten up your world!
            </p>
          </div>
        </div>
      </main>
    </div>
  );
}
