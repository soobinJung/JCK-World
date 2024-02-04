/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      fontFamily: {
        roboto: ['var(--roboto)'],
        pretendard: ['var(--pretendard)'],
      },
      colors: {
        primary: {
          50: '#eff1fe',
          100: '#e1e6fe',
          200: '#c9cffc',
          300: '#a8aff9',
          400: '#8585f4',
          500: '#7a72ee', // main
          600: '#604be0',
          700: '#533cc6',
          800: '#4333a0',
          900: '#3a317e',
          950: '#231c4a',
        },
      },
    },
  },
  plugins: [],
};
