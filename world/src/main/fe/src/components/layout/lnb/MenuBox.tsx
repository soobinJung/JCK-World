import { DefaultPropsType } from '@/types/common';

interface MenuBoxPropsType extends DefaultPropsType {
  active?: boolean;
}

function MenuBox({ children, active }: MenuBoxPropsType) {
  return (
    <div
      className={`${
        active ? 'bg-lavender-50 border border-lavender-200' : ''
      } cursor-pointer hover:bg-lavender-200 rounded-[12px]  w-[46px] h-[46px] flex items-center justify-center`}
    >
      {children}
    </div>
  );
}
export default MenuBox;
