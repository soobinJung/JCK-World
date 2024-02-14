import Link from 'next/link';
import Logo from '../home/icon/Logo';

function CommonGnb() {
  return (
    <div className="min-w-[calc(100vw-80px)] pl-8 pr-[96px] py-4 flex items-center justify-between fixed top-0 left-[80px]">
      <Link href={'/'}>
        <Logo />
      </Link>
      <div className="flex gap-1 items-center">
        <div className="text-violet-700 w-[100px] text-center font-[700]">
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
