import React from 'react';
import Logo from '../home/icon/Logo';
import Link from 'next/link';

function CommonLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-primary w-full min-h-screen">
      <Link href={'/'}>
        <Logo />
      </Link>
      {children}
    </div>
  );
}
export default CommonLayout;
