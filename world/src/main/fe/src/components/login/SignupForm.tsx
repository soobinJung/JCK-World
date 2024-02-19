'use client';
import { LoginInfoEnum } from '@/types/login';
import { useImmer } from 'use-immer';
import { Input } from '../common/Input';
import { Label } from '../common/Label';
import { Button } from '../common/Button';

function SignupForm() {
  const [userInfo, setUserInfo] = useImmer({
    name: '',
    id: '',
    password: '',
  });

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
  };

  const handleChangeValue = (type: LoginInfoEnum, value: string) => {
    setUserInfo((draft) => {
      draft[type] = value;
    });
  };

  return (
    <form onSubmit={handleSubmit} className="flex flex-col gap-2">
      <div className="flex items-center justify-center gap-2">
        <Label labelId="user-name">이름</Label>
        <Input
          labelId="user-name"
          value={userInfo.name}
          name={userInfo.name}
          placeholder="이름을 입력하세요"
          onChange={(value) => handleChangeValue(LoginInfoEnum.NAME, value)}
        ></Input>
      </div>
      <div className="flex items-center justify-center gap-2">
        <Label labelId="user-id">아이디</Label>
        <Input
          labelId="user-id"
          value={userInfo.id}
          name={userInfo.id}
          placeholder="사용할 아이디를 입력하세요"
          onChange={(value) => handleChangeValue(LoginInfoEnum.ID, value)}
        ></Input>
      </div>
      <div className="flex items-center justify-center gap-2">
        <Label labelId="user-password">비밀번호</Label>
        <Input
          labelId="user-password"
          value={userInfo.password}
          name={userInfo.password}
          type="password"
          placeholder="비밀번호를 입력하세요"
          onChange={(value) => handleChangeValue(LoginInfoEnum.ID, value)}
        ></Input>
      </div>
      <div className="flex items-center justify-center gap-2">
        <Label labelId="user-passconfirm">비밀번호</Label>
        <Input
          labelId="user-passconfirm"
          value={userInfo.password}
          name={userInfo.password}
          type="password"
          placeholder="비밀번호를 재입력하세요"
          onChange={(value) => handleChangeValue(LoginInfoEnum.ID, value)}
        ></Input>
      </div>
      <Button type="submit" aria-label="회원가입" style="mt-4">
        회원가입
      </Button>
    </form>
  );
}

export default SignupForm;
