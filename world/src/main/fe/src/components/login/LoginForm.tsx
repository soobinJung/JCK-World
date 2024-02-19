'use client';
import { LoginInfoEnum, LoginInfoType } from '@/types/login';
import React from 'react';
import { useImmer } from 'use-immer';
import { Input } from '../common/Input';
import { Button } from '../common/Button';

function LoginForm() {
  const [login, setLogin] = useImmer<LoginInfoType>({
    id: '',
    password: '',
  });

  const handleChangeValue = (type: LoginInfoEnum, value: string) => {
    setLogin((draft) => {
      draft[type] = value;
    });
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    console.log(login.id, login.password);
  };

  return (
    <form onSubmit={handleSubmit} className="flex flex-col gap-2">
      <Input
        value={login.id}
        name={login.id}
        placeholder="이름을 입력하세요"
        onChange={(value) => handleChangeValue(LoginInfoEnum.ID, value)}
      ></Input>
      <Input
        value={login.password}
        name={login.password}
        placeholder="비밀번호를 입력하세요"
        type="password"
        onChange={(value) => handleChangeValue(LoginInfoEnum.PASSWORD, value)}
      ></Input>
      <Button type="submit" aria-label="로그인" style="mt-4">
        로그인
      </Button>
    </form>
  );
}
export default LoginForm;
