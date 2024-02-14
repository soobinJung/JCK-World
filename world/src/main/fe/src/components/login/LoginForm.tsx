'use client';
import { LoginInfoEnum, LoginInfoType } from '@/types/login';
import React, { useState } from 'react';
import { useImmer } from 'use-immer';

function LoginForm() {
  const [login, setLogin] = useImmer<LoginInfoType>({
    email: '',
    password: '',
  });

  const handleChangeValue = (
    type: LoginInfoEnum,
    e: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setLogin((draft) => {
      draft[type] = e.target.value;
    });
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    console.log(login.email, login.password);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="m-4">
        <label htmlFor={LoginInfoEnum.EMAIL}>이메일</label>
        <input
          id={LoginInfoEnum.EMAIL}
          value={login.email}
          name={LoginInfoEnum.EMAIL}
          type={LoginInfoEnum.EMAIL}
          onChange={(e) => handleChangeValue(LoginInfoEnum.EMAIL, e)}
        ></input>
      </div>
      <div className="m-4">
        <label htmlFor={LoginInfoEnum.PASSWORD}>비밀번호</label>
        <input
          id={LoginInfoEnum.PASSWORD}
          value={login.password}
          name={LoginInfoEnum.PASSWORD}
          type={LoginInfoEnum.PASSWORD}
          onChange={(e) => handleChangeValue(LoginInfoEnum.PASSWORD, e)}
        ></input>
      </div>
      <button
        type="submit"
        aria-label="로그인"
        className="bg-lavender-500 px-4 py-2 rounded-md text-lavender-100 w-full"
      >
        로그인
      </button>
    </form>
  );
}
export default LoginForm;
