'use client';
import { LoginInfoEnum } from '@/types/login';
import { useImmer } from 'use-immer';

function SignupForm() {
  const [userInfo, setUserInfo] = useImmer({
    name: '',
    id: '',
    password: '',
  });

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
  };

  const handleChangeValue = (
    type: LoginInfoEnum,
    e: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setUserInfo((draft) => {
      draft[type] = e.target.value;
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="m-4">
        <div className="m-4">
          <label htmlFor={LoginInfoEnum.NAME}>이름</label>
          <input
            id={LoginInfoEnum.NAME}
            value={userInfo.name}
            name={LoginInfoEnum.NAME}
            type={LoginInfoEnum.NAME}
            onChange={(e) => handleChangeValue(LoginInfoEnum.NAME, e)}
          ></input>
        </div>
        <label htmlFor={LoginInfoEnum.ID}>아이디</label>
        <input
          id={LoginInfoEnum.ID}
          value={userInfo.id}
          name={LoginInfoEnum.ID}
          onChange={(e) => handleChangeValue(LoginInfoEnum.ID, e)}
        ></input>
      </div>
      <div className="m-4">
        <label htmlFor={LoginInfoEnum.PASSWORD}>비밀번호</label>
        <input
          id={LoginInfoEnum.PASSWORD}
          value={userInfo.password}
          name={LoginInfoEnum.PASSWORD}
          type={LoginInfoEnum.PASSWORD}
          onChange={(e) => handleChangeValue(LoginInfoEnum.PASSWORD, e)}
        ></input>
      </div>
      <button
        type="submit"
        aria-label="회원가입"
        className="bg-lavender-500 px-4 py-2 rounded-md text-lavender-100 w-full"
      >
        회원가입
      </button>
    </form>
  );
}

export default SignupForm;
