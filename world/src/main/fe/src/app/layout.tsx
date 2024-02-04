import type { Metadata } from 'next';
import { Noto_Sans_KR, Roboto } from 'next/font/google';
import localFont from 'next/font/local';
import './globals.css';

// globals.css 파일에서 font-face로 설정할까 했지만, google 폰트 지원하므로 next font로 설정
// className으로 설정하면 default
// css 속성을 통해 지정해주고 싶다면 variable 속성에 이름을 지정해주고 font-family에 적용
const noto_sans = Noto_Sans_KR({
  variable: '--noto-sans',
  subsets: ['latin'], // or preload: false
  weight: ['100', '400', '700', '900'],
});
const roboto = Roboto({
  subsets: ['latin'], // preload에 사용할 subsets입니다.
  weight: ['100', '400', '700'],
  variable: '--roboto', // CSS 변수 방식으로 스타일을 지정할 경우에 사용합니다.
});
const pretendard = localFont({
  src: './fonts/PretendardVariable.ttf',
  variable: '--pretendard',
  display: 'swap',
});

export const metadata: Metadata = {
  title: 'Create Next App',
  description: 'Generated by create next app',
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html
      lang="en"
      className={`${noto_sans.className} ${roboto.variable} ${pretendard.variable}`}
    >
      <body>{children}</body>
    </html>
  );
}
