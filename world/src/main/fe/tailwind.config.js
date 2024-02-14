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
        primary: '#eedcfc',
        lavender: {
          50: '#f8f8f8',
          100: '#f4e9fe',
          200: '#ebd6fe',
          300: '#dbb7fb',
          400: '#c588f8',
          500: '#b96ff3',
          600: '#9b39e4',
          700: '#8628c8',
          800: '#7126a3',
          900: '#5d2083',
          950: '#3f0a61',
        },
        violet: {
          400: '#a099e0',
          500: '#8f80d4',
          600: '#7f66c5',
          700: '#6750a4',
          800: '#59478c',
        },
        black: '#1c1c1c',
        red: {
          50: '#fef2f2',
          100: '#ffe1e1',
          200: '#ffc8c8',
          300: '#ffa2a2',
          400: '#fd6c6c',
          500: '#f53838',
          600: '#e31f1f',
          700: '#bf1616',
          800: '#9e1616',
          900: '#831919',
          950: '#470808',
        },
      },
    },
  },
  plugins: [],
};
