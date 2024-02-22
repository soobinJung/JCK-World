import { twMerge } from 'tailwind-merge';

interface ButtonPropsType {
  children: React.ReactNode;
  type?: 'button' | 'reset' | 'submit';
  ariaLabel?: string;
  style?: string;
  onClick?: () => void;
}

export function Button(props: ButtonPropsType) {
  const { children, type, style, ariaLabel, onClick } = props;
  return (
    <button
      className={twMerge(
        `flex items-center justify-center bg-lavender-500 font-[600] px-4 py-2 rounded-md text-lavender-100 w-full hover:bg-lavender-600 ${
          style && style
        }`,
      )}
      type={type && type}
      aria-label={ariaLabel && ariaLabel}
      onClick={onClick && onClick}
    >
      {children}
    </button>
  );
}
