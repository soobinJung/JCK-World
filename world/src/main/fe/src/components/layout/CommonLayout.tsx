import React from 'react';
import Logo from '../home/icon/Logo';
import Link from 'next/link';
import { DefaultPropsType } from '@/types/common';

function CommonLayout({ children }: DefaultPropsType) {
  return (
    <div className="bg-primary w-full min-h-screen">
      <Link href={'/'} className="fixed top-0 left-0">
        <Logo />
      </Link>
      {children}
    </div>
  );
}
export default CommonLayout;
