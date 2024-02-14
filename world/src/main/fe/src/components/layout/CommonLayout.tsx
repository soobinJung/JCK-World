import React from 'react';
import Logo from '../home/icon/Logo';
import Link from 'next/link';
import { DefaultPropsType } from '@/types/common';
import CommonGnb from './CommonGnb';

function CommonLayout({ children }: DefaultPropsType) {
  return (
    <div className="bg-primary w-full min-h-screen">
      <CommonGnb />
      {children}
    </div>
  );
}
export default CommonLayout;
