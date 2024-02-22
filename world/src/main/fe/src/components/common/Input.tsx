import { twMerge } from 'tailwind-merge';

interface InputPropsType {
  value: string;
  name: string;
  type?: string;
  style?: string;
  placeholder?: string;
  labelId?: string;
  onChange: (value: string) => void;
}

export function Input(props: InputPropsType) {
  const {
    value = '',
    name,
    type,
    style,
    placeholder = '내용을 입력하세요.',
    labelId,
    onChange,
  } = props;

  const handleChangeValue = (e: React.ChangeEvent<HTMLInputElement>) => {
    onChange(e.target.value);
  };

  const handleBlur = (e: React.FocusEvent<HTMLInputElement>) => {};

  const handleSubmit = (e: any) => {
    console.log(e.target.value);
  };

  return (
    <input
      id={labelId && labelId}
      value={value}
      name={name}
      type={type}
      className={twMerge(
        `block w-full rounded-[8px] text-black py-2 px-4 outline-none placeholder:text-gray300 border border-gray100
         focus:outline-none focus:bg-white focus:border-primary500 disabled:gray200 disabled:bg-gray100 disabled:text-gray300 ${
           style && style
         }`,
      )}
      placeholder={placeholder}
      onChange={handleChangeValue}
      onBlur={handleBlur}
      onSubmit={handleSubmit}
    ></input>
  );
}
