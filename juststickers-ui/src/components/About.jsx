import React from "react";
import PageTitle from "./PageTitle.jsx";

export default function About() {
  return (
    <div className=" mx-auto px-8 py-8 font-primary bg-normalbg dark:bg-darkbg">
      <div className="py-12 bg-normalbg dark:bg-darkbg font-primary">
        <div className="max-w-4xl mx-auto px-4">
          <PageTitle title="About JustStickers" />
        </div>
        <div className="text-center text-gray-600 dark:text-lighter flex flex-col items-center">
          <p className="max-w-[576px] px-2 mx-auto leading-6 mb-4">
            JustStickers is your one-stop destination for premium, durable, and
            affordable stickers designed to let you express yourself in the most
            creative way possible. Whether you're looking to personalize your
            laptop, decorate your water bottle, style your phone case, or add
            some flair to your notebooks, we’ve got something perfect for you.
            Our ever-growing collection includes hundreds of unique designs —
            from trendy aesthetics, minimalistic patterns, motivational quotes,
            anime and gaming themes, abstract art, and cute characters, to bold
            and quirky styles that make a statement. Whatever your taste, mood,
            or personality, there’s always a sticker that matches your vibe. At
            JustStickers, we believe stickers are more than just decorations —
            they’re a form of self-expression, a way to tell your story, and a
            simple way to make everyday items feel personal, fun, and uniquely
            yours. Every sticker is made with high-quality materials that ensure
            long-lasting color, strong adhesion, and resistance to water and
            scratches. Discover your style, express your creativity, and
            transform the ordinary into something extraordinary. Dive into our
            collection today and find the perfect stickers to brighten your
            world — one sticker at a time!
          </p>
        </div>
      </div>
    </div>
  );
}
