import React from 'react';
import { DefaultPropsType } from '@/types/common';
import CommonGnb from './CommonGnb';
import CommonLnb from './CommonLnb';

function CommonLayout({ children }: DefaultPropsType) {
  return (
    <div className="bg-primary w-full min-h-screen">
      <CommonGnb />
      <CommonLnb />
      {children}
    </div>
  );
}
export default CommonLayout;
