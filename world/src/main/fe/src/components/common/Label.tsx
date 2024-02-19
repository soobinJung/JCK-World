import { DefaultPropsType } from '@/types/common';
import React from 'react';
import { twMerge } from 'tailwind-merge';

interface LabelPropsType {
  children: React.ReactNode;
  labelId: string;
  style?: string;
}

export function Label(props: LabelPropsType) {
  const { children, labelId, style } = props;
  return (
    <label
      htmlFor={labelId}
      className={twMerge(
        `text-md text-gray-800 min-w-fit w-[100px] ${style && style}`,
      )}
    >
      {children}
    </label>
  );
}
