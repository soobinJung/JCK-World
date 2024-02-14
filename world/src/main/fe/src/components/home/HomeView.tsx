import { LuPencilLine } from 'react-icons/lu';
import { TiStarOutline } from 'react-icons/ti';
import { TbEraser } from 'react-icons/tb';

export default function HomeView() {
  return (
    <div className="w-full h-full">
      <div>
        <div>예정 시험일</div>
        <select>
          <option>필기</option>
          <option>실기</option>
        </select>
        <select>
          <option>1회차</option>
          <option>2회차</option>
          <option>3회차</option>
          <option>4회차</option>
        </select>
      </div>
      <h1>정보처리기사 필기 1회차</h1>
      <h1>D-40</h1>

      <div className="border border-lavender-300 w-full rounded-md min-h-[200px] bg-lavender-50 flex items-center justify-center">
        <div className="flex items-center justify-center gap-3 w-[500px]">
          <div className="bg-red-100 p-3 rounded-full cursor-pointer">
            <LuPencilLine className="w-[20px] h-[20px] text-red-500" />
          </div>
          <div>
            <div>푼 문제수</div>
            <p>로그인시 이용가능합니다.</p>
          </div>
        </div>
        <div className="flex items-center justify-center gap-3 w-[500px]">
          <div className="bg-red-100 p-3 rounded-full cursor-pointer">
            <TiStarOutline className="w-[20px] h-[20px] text-red-500" />
          </div>
          <div>
            <div>나만의 중요 문제</div>
            <p>로그인시 이용가능합니다.</p>
          </div>
        </div>
        <div className="flex items-center justify-center gap-3 w-[500px]">
          <div className="bg-red-100 p-3 rounded-full cursor-pointer">
            <TbEraser className="w-[20px] h-[20px] text-red-500" />
          </div>
          <div>
            <div>오답 문제 수</div>
            <p>로그인시 이용가능합니다.</p>
          </div>
        </div>
      </div>
    </div>
  );
}
