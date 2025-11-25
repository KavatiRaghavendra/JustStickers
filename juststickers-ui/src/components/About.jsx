import React from "react";
import PageTitle from "./PageTitle.jsx";

export default function About() {
  return (
    <div className="px-8 py-20 font-primary bg-normalbg dark:bg-darkbg">
      <div className="py-12 bg-normalbg dark:bg-darkbg font-primary">
        <div className="max-w-4xl mx-auto px-4">
          <PageTitle title="About JustStickers" />
        </div>
        <div className="text-center text-gray-600 dark:text-lighter flex flex-col items-center">
          <p className=" max-w-[800px]  px-2 mx-auto leading-6 mb-4">
            JustStickers is your one-stop shop for durable, high-quality
            stickers that let you show off your personality. We offer hundreds
            of unique designs, from minimal patterns and motivational quotes to
            anime, abstract art, and quirky characters. Our stickers are made to
            last — they’re water- and scratch-resistant, with strong adhesive.
            Whether you're decorating a laptop, water bottle, phone case, or
            notebook, we’ve got you covered. We believe in self-expression, not
            just decoration — stickers are a fun, affordable way to make your
            stuff feel uniquely yours. And we’re here for everyone — students,
            gamers, artists, or anyone who loves adding creative flair to their
            daily things. Dive in and find the sticker that fits your vibe — one
            sticker at a time.
          </p>
        </div>
      </div>
    </div>
  );
}
