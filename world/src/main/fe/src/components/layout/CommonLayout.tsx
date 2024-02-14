'use client';
import React from 'react';
import { DefaultPropsType } from '@/types/common';
import CommonGnb from './CommonGnb';
import CommonLnb from './CommonLnb';
import { usePathname } from 'next/navigation';
import { ROUTES } from '@/constants/routes';

function CommonLayout({ children }: DefaultPropsType) {
  const path = usePathname() as any;

  return (
    <div className="bg-primary w-full min-h-screen">
      <CommonGnb />
      {!Object.values(ROUTES.LOGIN).includes(path) && <CommonLnb />}
      {children}
    </div>
  );
}
export default CommonLayout;
