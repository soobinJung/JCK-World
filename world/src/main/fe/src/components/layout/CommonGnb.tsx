'use client';
import { usePathname, useRouter } from 'next/navigation';
import MenuBox from './lnb/MenuBox';
import { RiHomeLine } from 'react-icons/ri';
import { FaRegNoteSticky } from 'react-icons/fa6';
import { FiLogOut } from 'react-icons/fi';
import { IoSettingsSharp } from 'react-icons/io5';
import { FaBox } from 'react-icons/fa';
import { MdArrowRight } from 'react-icons/md';
import { ROUTES } from '@/constants/routes';

function CommonGnb() {
  const path = usePathname();

  const setIconColor = (active: boolean) => {
    if (active) return 'text-lavender-700';
    else return 'text-gray-700';
  };

  return (
    <div className="fixed left-0 top-0 bg-lavender-100 w-[80px] min-h-screen px-4 py-8 flex flex-col gap-4 items-center justify-between border-r border-lavender-200">
      <div className="absolute top-1/2 -right-4 cursor-pointer rounded-full bg-lavender-50 border border-lavender-300">
        <MdArrowRight className="text-[30px] text-lavender-700" />
      </div>
      <div className="flex flex-col gap-3">
        <MenuBox active={path === ROUTES.HOME}>
          <RiHomeLine
            className={`${setIconColor(path === ROUTES.HOME)} text-[20px]`}
          />
        </MenuBox>
        <MenuBox active={path === ROUTES.TEST.MAIN}>
          <FaRegNoteSticky
            className={`${setIconColor(path === ROUTES.TEST.MAIN)} text-[18px]`}
          />
        </MenuBox>
        <MenuBox active={path === ROUTES.DOCUMENTS.MAIN}>
          <FaBox
            className={`${setIconColor(
              path === ROUTES.DOCUMENTS.MAIN,
            )} text-[15px]`}
          />
        </MenuBox>
      </div>
      <div className="flex flex-col gap-2">
        <MenuBox>
          <FiLogOut className="text-[20px] text-black" />
        </MenuBox>
        <MenuBox>
          <IoSettingsSharp className="text-[20px] text-black" />
        </MenuBox>
      </div>
    </div>
  );
}

export default CommonGnb;
