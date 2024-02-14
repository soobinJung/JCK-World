import Link from 'next/link';
import Logo from '../home/icon/Logo';

function CommonGnb() {
  return (
    <div className="w-full p-4 flex items-center justify-between fixed top-0 left-0">
      <Link href={'/'}>
        <Logo />
      </Link>
      <div className="flex gap-3 items-center">
        <div className="text-lavender-900 w-[100px] text-center">
          <Link href={'/login'}>회원가입</Link>
        </div>
        <div className="text-red-500 rounded-full w-[100px] text-center p-2 border border-red-500">
          <Link href={'/login'}>로그인</Link>
        </div>
      </div>
    </div>
  );
}

export default CommonGnb;
