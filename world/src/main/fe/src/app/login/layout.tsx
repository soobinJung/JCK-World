import { DefaultPropsType } from '@/types/common';
import React from 'react';

export default function layout({ children }: DefaultPropsType) {
  return (
    <div className="flex items-center justify-center min-h-screen">
      {children}
    </div>
  );
}
