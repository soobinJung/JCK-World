'use client';
import React from 'react';
import { DefaultPropsType } from '@/types/common';
import CommonHeader from './CommonHeader';
import CommonGnb from './CommonGnb';
import { usePathname } from 'next/navigation';
import { ROUTES } from '@/constants/routes';

function CommonLayout({ children }: DefaultPropsType) {
  const path = usePathname() as any;

  const isCommonPage = () => {
    return !Object.values(ROUTES.LOGIN).includes(path);
  };

  return (
    <div className="bg-primary w-full min-h-screen">
      <CommonHeader />
      {isCommonPage() && <CommonGnb />}
      <div
        className={`${
          isCommonPage() &&
          'absolute top-[108px] left-[80px] w-[calc(100vw-80px)] h-[calc(100vh-108px)] px-16 py-8'
        }`}
      >
        {children}
      </div>
    </div>
  );
}
export default CommonLayout;
