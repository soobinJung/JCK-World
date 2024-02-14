import Link from 'next/link';
import Logo from './icon/Logo';

export default function HomeView() {
  const baseURL = process.env.NEXT_PUBLIC_API_URL;

  return (
    <div className="w-[100vw] h-[100vh] flex flex-col items-center justify-center bg-primary">
      <Logo />
      <Link href={'/login'}>로그인</Link>
    </div>
  );
}
