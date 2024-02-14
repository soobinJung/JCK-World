import React from 'react';
import Logo from '../home/icon/Logo';
import Link from 'next/link';
import { DefaultPropsType } from '@/types/common';

function CommonLayout({ children }: DefaultPropsType) {
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
